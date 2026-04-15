import csv
from faker import Faker

def generate_users():
    fake = Faker()

    file_path = 'users.csv'
    
    with open(file_path, 'w', newline='', encoding='utf-8') as f:
        writer = csv.writer(f)
        writer.writerow(['userId', 'email'])
        
        for user_id in range(1, 611):
            email = fake.unique.email()
            writer.writerow([user_id, email])
            
    print(f"Arquivo {file_path} gerado com sucesso com 610 usuários.")

if __name__ == "__main__":
    generate_users()
