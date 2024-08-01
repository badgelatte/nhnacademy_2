class Slot{
    String value;

    public Slot(String value) {
        this.value = value;
    }
}

public class Hashtable {
    Slot[] hashTable;
    public Hashtable(int size) {
        // Bucket & size개수 짜리의 Slot 생성 완료
        this.hashTable = new Slot[size];    
    }

    public int  hashFunction(String key) {
        // key의 젤 첫번째 글자를 int로 변환 후 hashTable의 length, 즉 size로 나눈 나머지를 반환
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean put(String key, String value) {
        int address = this.hashFunction(key);
        
        if(this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        }
        else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String get(String key) {
        int address = this.hashFunction(key);

        if(this.hashTable[address]!= null) {
            return this.hashTable[address].value;
        }
        else {
            return null;
        }
    }
}

class Test{
    public static void main(String[] args) {
        Hashtable table = new Hashtable(100);

        table.put("Celine", "Computer Science");
        table.put("James", "Naval Engineering");
        table.put("Robert","Computer Engineering");

        System.out.println(table.get("Celine"));
    }
}