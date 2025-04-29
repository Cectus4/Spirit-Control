from fastapi import FastAPI
from voice_and_text_analysis import TextAnalysis, VoiceAnalysis, to_string
from pydantic import BaseModel
import requests
import json

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

    final_stats = to_string(voiceAnalysis.analyze("tests/{0}-{1}.wav".format(emo_data.userId, emo_data.date)), "voiceByAniemore")+"\n"\
        +to_string(textAnalysis.voice_analyze("tests/{0}-{1}.wav".format(emo_data.userId, emo_data.date)), "voiceByGoogleAndRubert")+"\n"\
        +to_string(textAnalysis.text_analyze(emo_data.emoDict), "textByRubert")+"\n"
    
    data = {
        "id": "{0}".format(emo_data.id),
        "userId": "{0}".format(emo_data.userId),
        "emoDict": "{0}".format(final_stats),
        "date": "{0}".format(emo_data.date)
    }
    
    headers = {'Content-Type': 'application/json'}
    requests.post("http://localhost:8080/api/v1/spirit/emo-statistics/save", data=json.dumps(data), headers=headers)
    return {"msg": "k"}

#cd python
#uvicorn main:app --reload