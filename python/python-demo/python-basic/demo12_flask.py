from flask import Flask
import json
app = Flask(__name__)

@app.route("/test/<name>")
def index(name):
    return "name:"+name


if __name__ == "__main__":
    app.run()