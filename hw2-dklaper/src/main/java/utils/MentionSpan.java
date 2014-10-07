package utils;

import customtypes.GeneMention;
import edu.stanford.nlp.util.HasInterval;
import edu.stanford.nlp.util.Interval;

/**
 * Represents a span of a GeneMention
 * 
 */
public class MentionSpan implements HasInterval<Integer> {

	private GeneMention gene;
	// cache start an end in case GeneMention is null
	private int start;
	private int end;

	public GeneMention getGene()
	{
		return gene;
	}
	
	/**
	 * Initialize the span
	 * @param genesuper The mention to be represented as span
	 */
	public MentionSpan(GeneMention genesuper)
	{
		gene = genesuper;
		start = gene.getBegin();
		end = gene.getEnd();
	}
	
	/**
	 * @return Interval that is spanning this mention
	 */
	@Override
	public Interval<Integer> getInterval() {
		return new IntegerInterval(start, end);
	}
	
	// overriding comparison operators for use in hashmap
	@Override
	public int hashCode()
	{
		return ((Integer)start).hashCode()+1000*((Integer)end).hashCode();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other instanceof MentionSpan)
		{
			MentionSpan sp = (MentionSpan)other;
			if(sp.getInterval().equals(getInterval()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Represent the interval in Integers start and end
	 * 
	 */
	public class IntegerInterval extends Interval<Integer>
	{
		private static final long serialVersionUID = 1L;

		/**
		 * Create IntegerInterval
		 * @param start Starting index
		 * @param end End index
		 */
		public IntegerInterval(int start, int end)
		{
			super(start, end, 0);
		}
	}
	
	
}
