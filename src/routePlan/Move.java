package routePlan;

import interfaces.IMove;

/**
 * A class containing a single move, consisting of an X and a Y coordinate
 * 
 * @author Chris I 
 * XXIXIIMMXVI
 */
public class Move implements IMove {

		/** The X and Y coords of the move */
		private int x, y;
		
		/**
		 * Constructor to create a new move
		 * 
		 * @param x The X coord of the move to be created
		 * @param y The Y coord of the move to be created
		 */
		public Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		/**
		 * Get the X coord of a move
		 * 
		 * @return The X coord of the move
		 */
		public int getX() {
			return x;
		}

		/**
		 * Get the Y coord of a move
		 * 
		 * @return The Y coord of the move
		 */
		public int getY() {
			return y;
		}

		@Override
		public int getDirection() {
			// TODO Implement method
			return 0;
		}

		@Override
		public int setDirection() {
			// TODO Implement method
			return 0;
		}
		
}
