public class Entity<T extends Comparable<T>> implements Comparable<Entity<T>>{
	 private T t;
	 private int id;
	 private Entity<T> innerEntity; 
	 
	 public Entity(){	 
	 this((T) "Default T C'tor");
	 }
	  
	 public Entity(T t){
	 this(t, 100, null);
	 }
	 
	 public Entity(T t, int id){
		 this(t,id, null);
	 }
	 
	 public Entity(T t, int id, Entity<T> innerEntity) {
		 assert(id >= 1 && id <=100) : "Pre-Condition : id must be between 1 to 100";
		 if(!(id >= 1 && id <=100)) {
		        throw new IllegalArgumentException("Pre-Condition : id must be between 1 to 100");
		    } 
		 this.t = t;
		 this.id = id;
		 this.innerEntity = innerEntity;
	 }

	 public T getT() {
	 return t;
	 }
	 public void setT(T t) {
	 this.t = t;
	 }
	 public int getId() {
	 return id;
	 }
	 public void setId(int id) {
	 this.id = id;
	 }
	 public Entity<T> getInnerEntity() {
	 return innerEntity;
	 }
	 public void setInnerEntity(Entity<T> innerEntity) {
	 this.innerEntity = innerEntity;
	 }
	 
	 @Override
	 public boolean equals(Object o) {
	 if (this == o) return true;
	 if (!(o instanceof Entity)) return false;
	 Entity<?> entity = (Entity<?>) o;
	 if (id != entity.id) return false;
	 if (!t.equals(entity.t)) return false;
	 return innerEntity.equals(entity.innerEntity);
	 }
	 
	 @Override
	 public int hashCode() {
	 int result = t.hashCode();
	 result = 31 * result + id;
	 if (innerEntity != null) result = 31 * result + innerEntity.hashCode();
	 return result;
	 }
	 
	@Override
	public int compareTo(Entity<T> o) 
		{
			int result;
			
			if (!this.getT().getClass().getTypeName().equals(o.getT().getClass().getTypeName())){
		        result = this.getT().toString().compareTo(o.getT().toString());
		    }	    
			else if (!this.getT().equals(o.getT())){
		        result = this.getT().compareTo(o.getT());
		    }	    
		    else if (this.getId() != o.getId())
		    {
		    	result = Integer.compare(this.getId(), o.getId());		        
		    }
		    else if(this.getInnerEntity() != null || o.getInnerEntity() != null){
		    	if (this.getInnerEntity() == null ) {
		    		result = -1;
		    	}
		    	else if(o.getInnerEntity() == null)
		    	{
		    		result = 1;
		    	}
		    	else if(!this.getInnerEntity().equals(o.getInnerEntity())) {
		    		result = this.getInnerEntity().compareTo(o.getInnerEntity());
		    	}
		    	else {
		    		result = 0;
		    	}
		    }
		    else {
		        result = 0;
		    }
		    return  result;
		}
 
	@Override
	public String toString() { 
	    return String.format("T: " + this.getT() + "  ID: " + this.getId() + "  Inner Entity: " + this.getInnerEntity() + "  Class type: " + this.getClass().getName() + "  T type: " + this.getT().getClass().getTypeName()); 
	} 
}