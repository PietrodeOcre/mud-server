package mud.misc;

/*
  Copyright (c) 2012 Jeremy N. Harton
  
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
  persons to whom the Software is furnished to do so, subject to the following conditions:
  
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
  Software.
  
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

public class Effect
{
	public static enum Type { ACID, BURN, DAMAGE, HEAL, INVIS, POISON, RESIST };
	public static enum ResistType { ACID, FIRE, LIGHTNING };
	// LESSER, IMPROVED, GREATER, SUPERIOR
	public static enum DurationType { INSTANTANEOUS, PERMANENT, ROUNDS, SPECIAL };
	
	private static int lastId = 0; // the id of the last effect created
	
	private int id;                    // int
	private String name;               // name of effect (ex. 'invisibility', 'acid')
	private Type type;                 // damage, visibility, resistance, etc
	private ResistType rtype;          // for resistance effects, the type of resistance
	private DurationType durationType; // temporary vs. permanent, etc
	private int duration;              // effects duration in seconds (mask rounds by using a uniform length of round, in seconds)
	
	private boolean permanent = false;

	// explicit super constructor for subclassing
	protected Effect() {
	}

	public Effect(String eName) {
		id = nextID();
		name = eName;
		
		if (name.toLowerCase().contains("heal")) {
			type = Type.HEAL;
		}
		else if (name.toLowerCase().contains("invis")) {
			type = Type.INVIS;
		}
		else if (name.toLowerCase().contains("dam")) {
			type = Type.DAMAGE;
		}
	}

	public Effect(String eName, Type eType, DurationType eDurationType, int eDuration)
	{
		id = nextID();
		name = eName;
		type = eType;
		durationType = eDurationType;
		duration = eDuration;
		
		/*if (name.toLowerCase().contains("heal")) {
			type = Type.HEAL;
		}
		else if (name.toLowerCase().contains("invis")) {
			type = Type.INVIS;
		}
		else if (name.toLowerCase().contains("dam")) {
			type = Type.DAMAGE;
		}*/
	}
	
	public Effect(String eName, Type eType, DurationType eDurationType, int eDuration, boolean ePermanent)
	{
		this(eName, eType, eDurationType, eDuration);
		
		permanent = ePermanent;
	}
	
	public Effect(final Effect toCopy) {
		this(toCopy.getName(), toCopy.getType(), toCopy.getDurationType(), toCopy.getDuration());
		
		if( toCopy.isPermanent() ) {
			this.permanent = true;
		}
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String eName) {
		this.name = eName;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public DurationType getDurationType() {
		return durationType;
	}

	public void setDurationType(DurationType durationType) {
		this.durationType = durationType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static int nextID() {
		return lastId++;
	}
	
	public boolean isPermanent() {
		return this.permanent;
	}
	
	/*public boolean getPermanent() {
		return this.permanent;
	}*/
	
	/**
	 * Mark this effect as a permanent effect
	 * 
	 * @param state
	 */
	public void setPermanent(boolean state) {
		this.permanent = state;
	}

	public String toString() {
		return this.name;
	}
}