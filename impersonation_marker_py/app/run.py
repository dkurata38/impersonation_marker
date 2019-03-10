#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
声を分類してみる
'''
import librosa
import scipy
from scipy import io
from scipy.io import wavfile
import glob
import numpy as np
import os

from logging import getLogger, basicConfig, DEBUG, WARNING

logger = getLogger(__name__)

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
    x, fs = librosa.load(fn, sr=44100)

    mfccs = librosa.feature.mfcc(x, sr=fs)
    logger.debug(mfccs.shape)


if __name__ == '__main__':
    create_ceps('./data/info-girl1_info-girl1-omedetou1.wav')