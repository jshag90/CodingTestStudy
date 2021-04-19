# -*- coding: utf-8 -*-
"""
Created on Sun Jun 11 16:16:24 2017

@author: Minhyun
"""
from multiprocessing.pool import ThreadPool
import time
import pandas as pd
#import numpy as np

def parser(file_name, trg_word=None):
    df = pd.read_csv(file_name, header=None)
    df.columns = ['a', 'b', 'c']
    
#    trg_word = 'imap'
    cnt_word = 0
    cnt_line = 0
    
    
    for line in df['a']:
        cnt_word = 0
        words = line.split('-')
        
        if (trg_word in words):            
            cnt_line += 1 
            cnt_word += 1
#            print(cnt_line, cnt_word, line)
    return cnt_line
        
######################################################
# make new file
#new_file_name = '170604 - 알고리즘 sample02.txt'
#
#f = open(new_file_name, 'w')
#word_set = ['imap','smtp','ftp']
#num_line = 10000
##
#np.random.seed(1)
#for idx in range(num_line):
#    rnd = np.random.choice(word_set)
#    line = 'Pkt '+str(idx)+' : rule = Background Traffic-'+rnd+', ts idx = 0, content_set\n'
#    f.write(line)
#f.close()
######################################################        
if __name__ == "__main__":
    
    file_name = '170604 - 알고리즘 sample02.txt'
    t0 = time.clock();
    cnt = parser(file_name, 'imap')
    t0 = time.clock() - t0
    print(cnt, t0)
    
    pool = ThreadPool(processes=4)
    t0 = time.clock();
    t = pool.apply_async(parser, (file_name, 'imap'))    
    t0 = time.clock() - t0
    print(t.get(), t0)
    