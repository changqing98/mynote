import redis

if __name__ == "__main__":
    redis = redis.StrictRedis()
    redis.set("haha", "haha")
    print(str(redis.get("haha")))
