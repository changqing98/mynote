import json

from controller.app import app
from concurrent import *
@app.route('/')
def hello_world():
    return 'Hello, World!'


@app.route('/getJson')
def get_json_data():
    data = {"name": "changqing", "age": 11}
    return json.dumps(data)
