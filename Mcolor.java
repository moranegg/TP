


import

java.awt.Color;

public class Mcolor {

	Color couleur;

	Mcolor(int r, int g, int b) {
		setColor(r, g, b);
	}

	/**
	 * 
	 * retourne la couleur de Mcolor
	 */

	Color getColor() {
		return couleur;
	}

	/**
	 * 
	 * modifie la couleur courante par la combinaison rouge, vert et bleu
	 */

	void setColor(int r, int g, int b) {

		Color c =	new Color(r, g, b);
		this.couleur = c;
	}

	/**
	 * 
	 * modifie la couleur courante avec une nouvelle couleur definie
	 */

	void setColor(Color c) {
		this.couleur = c;
	}
	/**
	 * 
	 * modifie la couleur courante en plus clair
	 */
	void brighter() {
		this.couleur = couleur.brighter();
	}
	/**
	 * 
	 * pour avoir le rouge, le vert ou le bleu
	 */
	int getBlue() {
		return this.couleur.getBlue();
	}
	int getGreen() {
		return this.couleur.getGreen();
	}
	int getRed() {
		return this.couleur.getRed();
	}
	int getRGB() {
		return this.couleur.getRGB();
	}

	/**
	 * 
	 * modifie la couleur pour augmenter la composante rouge
	 */

	void redder() {
		int red = this.couleur.getRed();
		red = red + 25;
		if (red > 250) {
			red = 250;

		}

		setColor(red,
		this.couleur.getGreen(), this.couleur.getBlue());
	}

	/**
	 * 
	 * modifie la couleur pour augmenter la composante verte
	 */

	void greener() {
		int green = this.couleur.getGreen();
		green = green + 25;
		if (green > 250) {
			green = 250;
		}
		setColor(
		this.couleur.getRed(), green, this.couleur.getBlue());

	}

	/**
	 * 
	 * modifie la couleur pour augmenter la composante bleue
	 */

	void bluer() {
		int blue = this.couleur.getBlue();
		blue = blue + 25;
		if (blue > 250) {
			blue = 250;
		}

		setColor(
		this.couleur.getRed(), this.couleur.getGreen(), blue);

	}

	/**
	 * 
	 * modifie la couleur pour diminuer la composante rouge
	 */

	void lessRed() {

		int red = this.couleur.getRed();
		red = red - 25;
		if (red < 0) {
			red = 0;
		}
		setColor(red,this.couleur.getGreen(), this.couleur.getBlue());

	}
	/**
	 * 
	 * modifie la couleur pour diminuer la composante verte
	 */
	void lessGreen() {
		int green = this.couleur.getGreen();
		green = green - 25;
		if (green < 0) {
			green = 0;
		}
		setColor(
		this.couleur.getRed(), green, this.couleur.getBlue());
	}
	/**
	 * 
	 * modifie la couleur pour diminuer la composante bleue
	 */
	void lessBlue() {
		int blue = this.couleur.getBlue();
		blue = blue - 25;
		if (blue < 0) {
			blue = 0;
		}
		setColor(
		this.couleur.getRed(), this.couleur.getGreen(), blue);
	}

}
