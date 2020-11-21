from typing import Optional
from fastapi import FastAPI

app = FastAPI()

@app.get("/{name}")
def read(name: str, q: Optional[str] = None):
    return "Hello FastAPI" + name
