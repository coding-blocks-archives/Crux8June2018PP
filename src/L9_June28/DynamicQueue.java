package L9_June28;

/**
 * @author Garima Chhikara
 * @date Jul 16, 2018
 */

public class DynamicQueue extends Queue{

	@Override
	public void enqueue(int item) throws Exception {
		
		// twice
		if(this.size() == this.data.length) {
			
			int[] oa = this.data ;
			int[] na = new int[oa.length*2] ;
			
			for (int i = 0; i < this.size(); i++) {
				int idx = (i + this.front) % this.data.length;
				na[i] = oa[idx] ;
			}
			
			this.data = na ;
			this.front = 0;		
			
		}
		
		super.enqueue(item);

	}
}
