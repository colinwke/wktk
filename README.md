# wktk
a personal coding toolkit

python wktk simple use:
complete version: https://github.com/colinwke/wktk/blob/master/pylib/wktk.py

``` python
from time import time, ctime
from winsound import PlaySound, SND_ALIAS

import numpy as np
import pandas as pd

import pickle


class Timestamp(object):
    """
    how to use
    ts = Timestamp()  # 生成一个时间戳
    ts.cut()  # 打印一个时间戳, 以及与上一个时间戳的时间差
    ts.end()  # 打印时间戳运行的总时间
    ts.exit()  # 结束运行, 并打印时间戳运行的总时间
    """

    def __init__(self):
        self._start = time()
        self._cstart = self._start

        print("Timestamp start: %s" % str(ctime()))

    def cut(self, info=None):
        current = time()
        run_time = time() - self._cstart
        self._cstart = current

        print("Timestamp cut: %s, %.2fs" % (ctime(), run_time))
        if info is not None: print(info)

    def end(self, sound=False):
        run_time = time() - self._start
        print("Timestamp end: %s, %.2fs" % (ctime(), run_time))
        try:
            if sound:
                PlaySound('SystemQuestion', SND_ALIAS)
        except RuntimeError:
            print('RuntimeError: Faild to play sound!')

    def exit(self, info=None, sound=False):
        self.end(sound)

        if info is not None: print(info)
        exit(1015)


class PdPrinter:
    """
    how to use
    PdPrinter.print_full(data, info=None, max_row=10)  # 不断行打印df和numpy数组, 方便查看数组内容, max_row是打印的行号.
    """

    @staticmethod
    def format_df(df, info=None, max_rows=10, max_colwidth=50):
        if isinstance(df, np.ndarray):
            df = pd.DataFrame(df)
        content = '================  PdPrinter.print_full  ================\n'
        if info is not None:
            content = content + str(info) + '\n===\n'

        with pd.option_context(
                'display.max_rows', max_rows,
                'display.max_columns', None,
                'display.expand_frame_repr', False,
                'display.max_colwidth', max_colwidth
        ):
            return content + str(df)

    @staticmethod
    def print_full(df, info=None, max_rows=10, max_colwidth=50):
        print(PdPrinter.format_df(df, info, max_rows, max_colwidth))


class PickleUtils:
    """
    how to use
    PickleUtils.load_pickle(file_path) #  加载二进制缓存文件
    PickleUtils.dump_pickle(data, file_path)  # 保存二进制文件
    二进制文件比文本文件读取更快, 尤其对于需要格式化处理后的数据
    """

    @staticmethod
    def load_pickle(file_path):
        with open(file_path, 'rb') as f:
            ret = pickle.load(f)
            print('PickleUitls: load from %s success!' % file_path)
            return ret

    @staticmethod
    def dump_pickle(data, file_path):
        with open(file_path, 'wb') as f:
            pickle.dump(data, f, pickle.HIGHEST_PROTOCOL)
            print('PickleUitls: save to %s success!' % file_path)

```
