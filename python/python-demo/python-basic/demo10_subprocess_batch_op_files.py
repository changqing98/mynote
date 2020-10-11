import subprocess


def get_targets(path: str, name: str):
    command = 'find ' + path + ' -name ' + name
    print("search execute ", command)
    status, output = subprocess.getstatusoutput(command)
    files = output.split("\n")
    print(files)
    return files


def batch_update_files(path: str, name: str, text: str):
    files = get_targets(path, name)
    for file in files:
        print(file)
        file = open(file, 'w')
        file.write(text)
        file.close()


content = '''Configuration:
  status: warn
  Appenders:
    Console:
      name: Console
      target: SYSTEM_OUT
      PatternLayout:
        pattern: "%d{ISO8601} %-5p [%t] %c:%M:%L - %msg%n"
  Loggers:
    Root:
      level: INFO
      AppenderRef:
        - ref: Console
'''

if __name__ == "__main__":
    batch_update_files('/Users/glluenew/workspace/gllue/', 'log4j2.yml', content)
