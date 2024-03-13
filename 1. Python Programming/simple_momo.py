
import os
def memo():
    # 디렉토리 생성
    os.makedirs("output", exist_ok=True)
    print("저장할 파일명을 입력하세요.")
    filename = input("파일명: ")
    print("="*50)
    
    with open(f"output/{filename}", "wt", encoding="utf-8") as fw:
        print("저장할 내용을 입력하세요.")
        print("="*50)
        while True:
            line_txt = input(">>")
            if line_txt == "!q":
                break
            fw.write(line_txt+"\n")

if __name__ == "__main__":
    memo()
