import soundfile as sf
import os
from config import *

for file in os.listdir(OGG_2_WAV_INPUT):
    data, samplerate = sf.read(OGG_2_WAV_INPUT+file)
    sf.write(OGG_2_WAV_OUTPUT+file+'.wav', data, samplerate)