package gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is the content panes class. It will display the specified number of text fields
 * with labels in a two column format. Pass the title you want for the pane in the title
 * variable. The labels and fields are passed in as String arrays. Currently you need to
 * have the same number of labels and fields otherwise the program throw an array out of
 * bounds exception. The label index corresponds to the field index. The fields array is
 * for if you want default text to display in the field otherwise you can leave it blank.
 * 
 * 
 * @author John
 *
 */

public class ContentPane extends JPanel {
	
	private JLabel[] labelList;
	private JTextField[] fieldList;
	
	public ContentPane(String title, String[] labels, String[] fields) {
        // create labels
		labelList = new JLabel[labels.length];
        for(int i = 0; i < labels.length; i++) {
        	labelList[i] = new JLabel(labels[i]);
        }
        // create fields
        fieldList = new JTextField[fields.length];
        for(int i = 0; i < fields.length; i++) {
        	fieldList[i]= new JTextField(fields[i]);
        	fieldList[i].setPreferredSize(new Dimension(100, 10));
        }
        // layout stuff
		this.setBorder(BorderFactory.createTitledBorder(title));
		GroupLayout layout = new GroupLayout(this); 
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        // create horizontal layout groups
        ParallelGroup trailingHGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        ParallelGroup leadingHGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for(int i = 0; i < labelList.length; i++) {
        	trailingHGroup.addComponent(labelList[i]);
        	leadingHGroup.addComponent(fieldList[i]);
        }
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(trailingHGroup)
                .addGroup(leadingHGroup)
        	);
        // create vertical layout groups
        SequentialGroup vGroup = layout.createSequentialGroup();
        ParallelGroup[] vGroups = new ParallelGroup[labelList.length];
        for(int i = 0; i < labelList.length; i++) {
        	vGroups[i] = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
        	vGroups[i].addComponent(labelList[i]);
        	vGroups[i].addComponent(fieldList[i]);
        	vGroup.addGroup(vGroups[i]);
        }
        layout.setVerticalGroup(vGroup);
	}
	
	public String[] getFields() {
		String[] fields = new String[fieldList.length];
		for(int i = 0; i < fieldList.length; i++) {
			fields[i] = fieldList[i].getText();
		}
		return fields;
	}
	
	public String[] getLabels() {
		String[] labels = new String[labelList.length];
		for(int i = 0; i < labelList.length; i++) {
			labels[i] = labelList[i].getText();
		}
		return labels;
	}
}
