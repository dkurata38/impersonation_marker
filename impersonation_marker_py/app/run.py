#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
声を分類してみる
'''
from python_speech_features import mfcc
from matplotlib.pyplot import specgram
from matplotlib import pylab
from sklearn.metrics import confusion_matrix
from sklearn.svm import LinearSVC
from sklearn.utils import resample
import scipy
from scipy import io
from scipy.io import wavfile
import glob
import numpy as np
import os

from logging import getLogger, basicConfig, DEBUG, WARNING

logger = getLogger(__name__)
BASE_DIR = '/app/data/'
basicConfig(
    level = DEBUG,
    format = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)

def write_ceps(ceps,fn):
    base_fn,ext = os.path.splitext(fn)
    data_fn = base_fn + ".ceps"
    np.save(data_fn,ceps)

def create_ceps(fn):
    # sample_rate,X = io.wavfile.read(fn)
    rate, sig = io.wavfile.read(fn)
    ceps = mfcc(sig, rate)

    write_ceps(ceps, fn)

def read_ceps(name_list,base_dir = BASE_DIR):
    X,y = [],[]
    for label,name in enumerate(name_list):
        for fn in glob.glob(os.path.join(base_dir,name,"*.ceps.npy")):
            ceps = np.load(fn)
            num_ceps = len(ceps)
            X.append(np.mean(ceps[:],axis=0))
            y.append(label)
    return np.array(X),np.array(y)

def normalisation(cm):
    new_cm = []
    for line in cm:
        sum_val = sum(line)
        new_array = [float(num)/float(sum_val) for num in line]
        new_cm.append(new_array)
    return new_cm

def plot_confusion_matrix(cm,name_list,name,title):
    pylab.clf()
    pylab.matshow(cm,fignum=False,cmap='Blues',vmin=0,vmax=1.0)
    ax = pylab.axes()
    ax.set_xticks(range(len(name_list)))
    ax.set_xticklabels(name_list)
    ax.xaxis.set_ticks_position("bottom")
    ax.set_yticks(range(len(name_list)))
    ax.set_yticklabels(name_list)
    pylab.title(title)
    pylab.colorbar()
    pylab.grid(False)
    pylab.xlabel('Predict class')
    pylab.ylabel('True class')
    pylab.grid(False)
    pylab.show()

if __name__ == '__main__':
    create_ceps('./data/info-girl1_info-girl1-omedetou1.wav')

    name_list = ["test"]

    x,y = read_ceps(name_list, base_dir='/app/data')
    svc = LinearSVC(C=1.0)
    x,y = resample(x,y,n_samples=len(y))
    svc.fit(x[150:],y[150:])
    prediction = svc.predict(x[:150])
    cm = confusion_matrix(y[:150],prediction)
