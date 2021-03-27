import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TrisFrame extends JFrame implements MouseListener {
	
	private int r = 3;
	private int c = 3;
	private int turno;
	private JButton mat[][] = new JButton[r][c];
	private JPanel pnl = new JPanel();
	private JButton rigioca = new JButton("RIGIOCA");
	public TrisFrame() {
		super("Tris Game");
	    pnl.setLayout(new GridLayout(r,c));
	    Container C = this.getContentPane();
	    C.setLayout(new BorderLayout());

		
		int i, j;
		
		for(i=0; i<r; i++)
			for(j=0; j<c; j++)
			{
				mat[i][j] = new JButton();
				pnl.add(mat[i][j]);
				mat[i][j].setBackground(Color.WHITE);
				mat[i][j].addMouseListener(this);
			}
		rigioca.setBackground(Color.LIGHT_GRAY);
		rigioca.addMouseListener(this);
		C.add(pnl, BorderLayout.CENTER);
		C.add(rigioca, BorderLayout.SOUTH);
		setVisible(true);
		setSize(500,500);
		turno = 1;
	}
	
public boolean controllo() {
	int i,j;
	boolean s = true;
	for(j=0,i=0; i<r; i++, j=0)
	
		if((mat[i][j].getText()).equals(mat[i][j+1].getText()) && (mat[i][j].getText()).equals(mat[i][j+2].getText()) && (!(mat[i][j].getText()).equals("")))
			return true;

	for(i=0, j=0; j<c; j++, i=0)
		if((mat[i][j].getText()).equals(mat[i+1][j].getText()) && (mat[i][j].getText()).equals(mat[i+2][j].getText()) && (!(mat[i][j].getText()).equals("")))
             return true;
	
	for(i=0, j=0; i<r-1 && j<c-1; i++,j++)
	    if(!(mat[i][j].getText()).equals(mat[i+1][j+1].getText()) || ((mat[i][j].getText()).equals(""))||((mat[i+1][j+1].getText()).equals("")))
		    s = false;
	if(s)
		return s;
	
	for(i=0, j=c-1; i<r-1 && j>0; i++, j--)
	    if(!(mat[i][j].getText()).equals(mat[i+1][j-1].getText()) || ((mat[i][j].getText()).equals(""))||((mat[i+1][j-1].getText()).equals("")))
           return false;

	return true;
	
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int i,j;
		for(i=0; i<r; i++)
			for(j=0; j<c; j++)
		if(e.getSource() == mat[i][j]) {
			
			if((mat[i][j].getText()).equals("")) {
				
				if(turno == 1) {
					mat[i][j].setText("X");
					turno = 2;
					if(controllo() == true)
					{
						JOptionPane.showMessageDialog(null, "IL VINCITORE È: X ");
						turno = 0;

					}
				}
				else if(turno == 2) {
					mat[i][j].setText("O");
					turno = 1;
					if(controllo() == true)
					{
						JOptionPane.showMessageDialog(null, "IL VINCITORE È: O ");
						turno = 0;

					}
				}
				
			}
			break;
		}
       
       if(e.getSource() == rigioca) {
    	   for(i=0; i<r; i++)
    		   for(j=0; j<c; j++)
    			   mat[i][j].setText("");
    	   turno = 1;
       }
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
