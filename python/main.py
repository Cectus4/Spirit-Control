from fastapi import FastAPI
from voice_and_text_analysis import TextAnalysis, VoiceAnalysis, to_string
from pydantic import BaseModel
import requests
import json
from config import *

class EmoStatistics(BaseModel):
    id: int
    userId: int
    emoDict: str
    date: str


app = FastAPI()
textAnalysis = TextAnalysis()
voiceAnalysis = VoiceAnalysis()

@app.post("/api/v1/spirit/emo-statistics/generate")
async def generate_stats(emo_data: EmoStatistics):

    final_stats = to_string(voiceAnalysis.analyze(AUDIO_PATH.format(emo_data.userId, emo_data.date)), VOICE_BY_ANIEMORE)+"\n"\
        +to_string(textAnalysis.voice_analyze(AUDIO_PATH.format(emo_data.userId, emo_data.date)), VOICE_BY_GOOGLE_AND_RUBERT)+"\n"\
        +to_string(textAnalysis.text_analyze(emo_data.emoDict), TEXT_BY_RUBERT)+"\n"
    
    data = {
        "id": "{0}".format(emo_data.id),
        "userId": "{0}".format(emo_data.userId),
        "emoDict": "{0}".format(final_stats),
        "date": "{0}".format(emo_data.date)
    }
    
    headers = {'Content-Type': 'application/json'}
    requests.post("http://localhost:8080/api/v1/spirit/emo-statistics/save", data=json.dumps(data), headers=headers)
    return MESSAGE

#cd python
#uvicorn main:app --reload
#python -m uvicorn main:app --reload  