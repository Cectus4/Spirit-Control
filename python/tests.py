import os
from aniemoresimple import vr, emotions_percent, to_string
import warnings

warnings.filterwarnings("ignore")

vr = vr()

c=1
for file in os.listdir("python/tests"):
    print("-----------"+str(c)+"File-----------\n\n"\
        +to_string(vr.recognize("python/tests/"+file))+"\n"+to_string(emotions_percent(vr.recognize("python/tests/"+file)), "%"))
    c+=1