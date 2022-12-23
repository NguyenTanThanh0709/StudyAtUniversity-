
public class Priority {
    Person[] prority;
    int size;
    public Priority(int size){
        this.prority = new Person[size];
        this.size = 0;
    }

    public void shifUp(int index){
        if(this.size == 0){
            return;
        }
        int parentIndex = index /2;
        while(index > 1 && prority[parentIndex].priority < prority[index].priority){        
            Person temp = prority[parentIndex];
            prority[parentIndex] = prority[index];
            prority[index] = temp;
            index = parentIndex;
            parentIndex = index/2;
            
        }
    }

    public int indexParent(int index){
        return index / 2;
    }

    public int indexLeft(int index){
        return 2*index;
    }

    public int indexRight(int index){
        return 2*index + 1;
    }

    public void shifDown(int index){
        while(index < this.size){
            if(this.prority[index].priority < this.prority[indexLeft(index)].priority &&  this.prority[index].priority < this.prority[indexRight(index)].priority){
                if(this.prority[indexLeft(index)].priority > this.prority[indexRight(index)].priority){
                    Person temp = prority[indexLeft(index)];
                    prority[indexLeft(index)] = prority[index];
                    prority[index] = temp;
                    index = indexLeft(index);
                }else{
                    Person temp = prority[indexRight(index)];
                    prority[indexRight(index)] = prority[index];
                    prority[index] = temp;
                    index = indexRight(index);
                }
            }else if(this.prority[index].priority < this.prority[indexLeft(index)].priority){
                Person temp = prority[indexLeft(index)];
                    prority[indexLeft(index)] = prority[index];
                    prority[index] = temp;
                    index = indexLeft(index);
            }else if(this.prority[index].priority < this.prority[indexRight(index)].priority){
                Person temp = prority[indexRight(index)];
                    prority[indexRight(index)] = prority[index];
                    prority[index] = temp;
                    index = indexRight(index);
            }
        }
   
    }

    public void enqueue(String name, int priority){
        this.size++;
        this.prority[size] = new Person();
        this.prority[size].name = name;
        this.prority[size].priority = priority;
        shifUp(this.size-1);
    }

    public Person dequeue(){
        Person temp = this.prority[1];
        this.prority[1] = this.prority[size];
        this.size--;
        shifDown(1);
        return temp;
    }

    public void print(){
        for(int i = 1; i < this.size+1; i++){
            System.out.println(prority[i].toString());
        }
    }
}
