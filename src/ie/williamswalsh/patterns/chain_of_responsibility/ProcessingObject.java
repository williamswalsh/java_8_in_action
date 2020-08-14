package ie.williamswalsh.patterns.chain_of_responsibility;

public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> sucessor;

    public void setSucessor(ProcessingObject<T> sucessor) {
        this.sucessor = sucessor;
    }

    public T handle(T input){
        T r = handleWork(input);
        if(sucessor != null) {
            return sucessor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T msg);
}
