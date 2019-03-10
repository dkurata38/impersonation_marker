#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
特徴量の算出
'''
from python_speech_features import mfcc
import scipy
from scipy import io
from scipy.io import wavfile
import numpy as np

import os
import glob
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
    try:
        rate, sig = io.wavfile.read(fn)
        ceps = mfcc(sig, rate)
        write_ceps(ceps, fn)
    except ValueError as verr:
        logger.warning('{} is {}.'.format(fn, verr))


if __name__ == '__main__':
    base_dir = '/app/data/'
    dir_name = ['anago', 'notanago']
    for dn in dir_name:
        for fn in glob.glob(os.path.join(base_dir, dn, "*.wav")):
            create_ceps(fn)
