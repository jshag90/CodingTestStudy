# -*- coding: utf-8 -*-
"""
Created on Sun Jun 11 16:16:24 2017

@author: Minhyun
"""

import pandas as pd
import numpy as np


file_name = '170604 - 알고리즘 sample01.txt'

df = pd.read_csv(file_name, header=None)
df.columns = ['a', 'b', 'c']

target_word = 'imap'
cnt_word = 0
cnt_line = 0

for line in df['a']:
    cnt_line += 1 
    cnt_word = 0
    words = line.split('-')
#    print(words)
    
    if (target_word in words):
        cnt_word += 1
        print(cnt_line, cnt_word, line)
        
######################################################
# make new file
new_file_name = '170604 - 알고리즘 sample02.txt'

f = open(new_file_name, 'w')
word_set = ['imap','smtp','ftp']
num_line = 10000

np.random.seed(1)
for idx in range(num_line):
    rnd = np.random.choice(word_set)
    line = 'Pkt '+str(idx)+' : rule = Background Traffic-'+rnd+', ts idx = 0, content_set\n'
    f.write(line)
f.close()
