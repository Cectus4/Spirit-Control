from fastapi import FastAPI
from pydantic import BaseModel
from aniemoresimple import vr, to_string
import requests
import json

app = FastAPI()
vr = vr()

class EmoStatistics(BaseModel):
    id: int
    userId: int
    emoDict: str
    date: str

@app.post("/api/v1/spirit/emo-statistics/generate")
async def generate_stats(emo_data: EmoStatistics):

    final_stats = to_string(vr.recognize("tests/{0}{1}.wav".format(emo_data.userId, emo_data.date)))
    data = {
        "id": "{0}".format(emo_data.id),
        "userId": "{0}".format(emo_data.userId),
        "emoDict": "{0}".format(final_stats),
        "date": "{0}".format(emo_data.date)
    }
    print(data)
    headers = {'Content-Type': 'application/json'}
    requests.post("http://localhost:8080/api/v1/spirit/emo-statistics/save", data=json.dumps(data), headers=headers)
    return {"msg": "k"}

#cd python
#uvicorn main:app --reload