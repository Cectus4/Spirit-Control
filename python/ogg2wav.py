import soundfile as sf
import os

for file in os.listdir("python/ogg2wavInput/"):
    data, samplerate = sf.read("python/ogg2wavInput/"+file)
    sf.write('python/ogg2wavOutput/'+file+'.wav', data, samplerate)