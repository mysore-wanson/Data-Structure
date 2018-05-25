package CheckIdea;
public class Array<ElementType> {//泛型需要注意的地方
    private ElementType[] data;
    private int size;
    public Array(int capacity) {//构造函数，传入数组的容量capacity构造Array
        data=(ElementType[])new Object[capacity];//泛型需要注意的地方
        size=0;
    }
    public Array() {//无参构造函数，默认数组的容量capacity=10
        this(10);
    }
    public int getSize() {//获取数组中的元素个数
        return size;
    }

    public int getCapacity() {//获取数组的容量
        return data.length;
    }
    public boolean isEmpty(){//返回数组是否为空
        return size==0;
    }
    public void addLast(ElementType e){//向所有元素后添加一个新的元素
        add(size,e);
    }
    public void addFirst(ElementType e){//在所有元素前面添加一个新的元素
        add(0,e);
    }
    public void add(int index,ElementType e){//在第index个位置插入一个新的元素e
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed.required index>=0 and  index<=size.");
        }
        if(size==data.length){
            resize(2*data.length);
        }
        for (int i =size-1 ; i >=index ; i--) {
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    public ElementType get(int index){ //获取index索引位置的元素
        if (index<0||index>=size){
            throw new IllegalArgumentException("Set failed,Index is illegal.");
        }
        return data[index];
    }
    public ElementType getLast(){//获取最后一个元素
        return get(size-1);
    }
    public ElementType getFirst(){//获取第一个元素
        return get(0);
    }
    public void set(int index,ElementType e){//修改index 索引位置的元素为e
        data[index]=e;
    }
    public boolean contains(ElementType e){//查找数组中的元素是否有元素e
        for (int i = 0; i <size ; i++) {
            if (data[i].equals(e)/*泛型注意*/){
                return true;
            }
        }
        return false;
    }
    public int find(int e){ //查找数组中元素e所在的索引，如果不存在元素e,则返回-1
        for (int i = 0; i <size ; i++) {
            if (data[i].equals(e)/*泛型注意*/){
                return i;
            }
        }
        return -1;
    }
    //从数组中删除index位置的元素，返回删除的元素
    public ElementType remove(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Remove failed,Index is illegal.");
        }
        ElementType result=data[index];
        for (int i = index+1; i <size ; i++) {
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;//泛型注意
        if (size==data.length/2){//缩容技术处理
            resize(data.length/2);
        }
        return result;
    }
    public ElementType removeFirst(){//从数组中删除第一个元素
        return remove(0);
    }
    public ElementType removeLast(){ //从数组中删除最后一个元素
        return remove(size-1);
    }
    public void removeElement(int e){//从数组中删除元素e
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }
        @Override
    public String toString(){//打印数组元素
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        stringBuffer.append('[');
        for (int i = 0; i <size ; i++) {
            stringBuffer.append(data[i]);
            if (i!=size-1){
                stringBuffer.append(",\t");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity){//扩容技术处理

        ElementType[] newData = (ElementType[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
