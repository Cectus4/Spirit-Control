import soundfile as sf
import os

data, samplerate = sf.read("python/ogg2wavInput/"+os.listdir("python/ogg2wavInput/")[0])

sf.write('python/ogg2wavOutput/'+os.listdir("python/ogg2wavInput/")[0]+'.wav', data, samplerate)