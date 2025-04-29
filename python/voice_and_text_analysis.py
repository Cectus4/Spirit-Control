import torch
from aniemore.recognizers.voice import VoiceRecognizer
from aniemore.models import HuggingFaceModel
import speech_recognition as sr
from transformers import pipeline
from config import *

class TextAnalysis:

    def __init__(self):

        self.recognizer = sr.Recognizer()
        self.emo_analyzer = pipeline(        
            "text-classification", 
            model="cointegrated/rubert-tiny2-cedr-emotion-detection",
            return_all_scores=True
            )


    def text_analyze(self, text):

        d = self.emo_analyzer(text)
        r = {}
        for i in d[0]:
            r[i["label"]]=i["score"]

        return emotions_percent(r)


    def voice_analyze(self, path):

        with sr.AudioFile(path) as source:
            audio_data = self.recognizer.record(source) 

        try:

            text = self.recognizer.recognize_google(audio_data, language="ru-RU")
            d = self.emo_analyzer(text)
            r = {}
            for i in d[0]:
                r[i["label"]]=i["score"]

            return emotions_percent(r)
        
        except:

            return -1



class VoiceAnalysis:

    def __init__(self, emo_multi_path=ANIEMORE_EMO_MULTI_PATH):
        
        model = HuggingFaceModel.Voice.WavLM
        device = 'cuda' if torch.cuda.is_available() else 'cpu'
        self.voiceRecognizer = VoiceRecognizer(model=model, device=device)
        self.emotion_multipliers = [line.replace("\n", "") for line in open(emo_multi_path)]


    def analyze(self, file_name):

        analysis = self.voiceRecognizer.recognize(file_name, return_single_label=False)

        for multiplier in self.emotion_multipliers:
            analysis[multiplier.split(":")[0]]=analysis.get(multiplier.split(":")[0])*float(multiplier.split(":")[1])

        return emotions_percent(analysis)



def emotions_percent(dict):
    
    s = sum([dict.get(emotion) for emotion in dict])
    r = {}
    for emotion in dict:
        r[emotion]=float("{0:.1f}".format(dict.get(emotion)*100/s))

    return r



def to_string(dict, type):

    for emotion in dict:
        type+="|"+emotion[0].upper()+emotion[1:]+":"+str(dict.get(emotion))

    return type