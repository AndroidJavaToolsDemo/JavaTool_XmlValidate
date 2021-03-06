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
		this.setTitle("xml格式化工具(xiaxveliang.blog.163.com)");
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
			// 获取字符串
			String temps = jta.getText();
			//格式化
			byte[] data = XmlUtils.outPut(temps);
			// 将格式化后的文本进行显示
			try {
				jta.setText(new String(data, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
	}

	// 程序入口
	public static void main(String args[]) {
		// swing
		new JHH();
	}
}
