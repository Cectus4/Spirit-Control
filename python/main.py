import threading
from fastapi import FastAPI, BackgroundTasks
from pydantic import BaseModel
from datetime import datetime

app = FastAPI()

class EmoStatistics(BaseModel):
    id: int
    userId: int
    emoDict: str
    date: datetime

def process_emo_data(emo_data: EmoStatistics):
    print(f"Обрабатываю данные: {emo_data}")


@app.post("/api/v1/spirit/emo-statistics/generate")
async def generate_stats(emo_data: EmoStatistics):

    thread = threading.Thread(target=process_emo_data, args=(emo_data,), daemon=True)
    thread.start()

    return {"msg": "k"}

#cd python
#uvicorn main:app --reload
