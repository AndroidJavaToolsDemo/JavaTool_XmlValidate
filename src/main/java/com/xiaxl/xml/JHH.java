package com.xiaxl.xml;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JHH extends JFrame implements ActionListener {
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	JButton chengButton = new JButton("validate(xiaxveliang.blog.163.com)");

	public JHH() {
		this.setTitle("xml��ʽ������(xiaxveliang.blog.163.com)");
		this.add(jsp, BorderLayout.CENTER);
		this.add(chengButton, BorderLayout.SOUTH);
		this.setBounds(20, 20, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chengButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chengButton) {
			// ��ȡ�ַ���
			String temps = jta.getText();
			//��ʽ��
			byte[] data = XmlUtils.outPut(temps);
			// ����ʽ������ı�������ʾ
			try {
				jta.setText(new String(data, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
	}

	// �������
	public static void main(String args[]) {
		// swing
		new JHH();
	}
}
