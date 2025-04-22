import torch
from aniemore.recognizers.voice import VoiceRecognizer
from aniemore.models import HuggingFaceModel


class vr:

    def __init__(self, emo_multi_path="python/emotion_multiplier.txt"):
        
        model = HuggingFaceModel.Voice.WavLM
        device = 'cuda' if torch.cuda.is_available() else 'cpu'
        self.voiceRecognizer = VoiceRecognizer(model=model, device=device)
        self.emotion_multipliers = [line.replace("\n", "") for line in open(emo_multi_path)]
        


    def recognize(self, file_name):
        
        analysis = self.voiceRecognizer.recognize(file_name, return_single_label=False)
        
        for multiplier in self.emotion_multipliers:
            analysis[multiplier.split(":")[0]]=analysis.get(multiplier.split(":")[0])*float(multiplier.split(":")[1])

        return analysis



def emotions_percent(dict):
    
    s = sum([dict.get(emotion) for emotion in dict])
    r = {}
    for emotion in dict:
        r[emotion]=float("{0:.1f}".format(dict.get(emotion)*100/s))
    
    return r

def to_string(dict, type="base"):
    endl = ""
    match type:
        case "base":
            endl="\n"
            r = "Emotions:\n"
        case "%":
            endl="%\n"
            r = "Percents:\n"
            
    for emotion in dict:
        r+=emotion[0].upper()+emotion[1:]+": "+str(dict.get(emotion))+endl
    return r