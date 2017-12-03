import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ThreadedWorkers {
	public static void main(String[] paramArrayOfString) {
		ThreadedWorkerFrame localThreadedWorkerFrame = new ThreadedWorkerFrame();
		localThreadedWorkerFrame.setDefaultCloseOperation(3);
		localThreadedWorkerFrame.setVisible(true);
	}
}
	class ThreadedWorkerFrame extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextArea ta = new JTextArea(40, 8);

		public ThreadedWorkerFrame() {
			Toolkit localToolkit = Toolkit.getDefaultToolkit();
			Dimension localDimension = localToolkit.getScreenSize();
			int i = localDimension.height;
			int j = localDimension.width;
			setSize(j / 2, i / 2);
			setLocationByPlatform(true);
			setTitle("Threaded Workers Program");
			add(new ThreadedWorkerFrame.ButtonPanel(), "North");
			add(new JScrollPane(this.ta), "Center");
		}

		class WorkerRunnable implements Runnable {
			private String name;
			private int delay;

			public WorkerRunnable(String paramString, int paramInt) {
				this.name = paramString;
				this.delay = paramInt;
			}

			public WorkerRunnable(ThreadedWorkerFrame threadedWorkerFrame, String string, int i) {
				// TODO Auto-generated constructor stub
			}

			public void run() {
				long l = 0L;
				for (;;) {
					synchronized (ThreadedWorkerFrame.this) {
						ThreadedWorkerFrame.this.ta.append(this.name + " is working, count = " + l++ + "\n");
					}
					try {
						Thread.sleep(this.delay);
					} catch (InterruptedException localInterruptedException) {
					}
				}
			}
		}

		class ButtonPanel extends JPanel {

			private static final long serialVersionUID = 1L;

			public ButtonPanel() {
				final JButton localJButton1 = new JButton("Tim (5 sec)");
				final JButton localJButton2 = new JButton("Suzy (3 sec)");
				final JButton localJButton3 = new JButton("Edna (2 sec)");

				localJButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						localJButton1.setEnabled(false);
						Thread localThread = new Thread(
								new ThreadedWorkerFrame.WorkerRunnable(ThreadedWorkerFrame.this, "Tim", 5000));
						localThread.start();
					}
				});
				add(localJButton1);
				localJButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						localJButton2.setEnabled(false);
						Thread localThread = new Thread(
								new ThreadedWorkerFrame.WorkerRunnable(ThreadedWorkerFrame.this, "Suzy", 3000));
						localThread.start();
					}
				});
				add(localJButton2);
				localJButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						localJButton3.setEnabled(false);
						Thread localThread = new Thread(
								new ThreadedWorkerFrame.WorkerRunnable(ThreadedWorkerFrame.this, "Edna", 2000));
						localThread.start();
					}
				});
				add(localJButton3);
			}
		}
	}

	class ButtonPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ButtonPanel() {
			JButton localJButton1 = new JButton("Tim (5 sec)");
			JButton localJButton2 = new JButton("Suzy (3 sec)");
			JButton localJButton3 = new JButton("Edna (2 sec)");

			localJButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					Thread localThread = new Thread(new WorkerRunnable("Tim", 5000));
					localThread.start();
				}
			});
			add(localJButton1);
			localJButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					Thread localThread = new Thread(new WorkerRunnable("Suzy", 3000));
					localThread.start();
				}
			});
			add(localJButton2);
			localJButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					Thread localThread = new Thread(new WorkerRunnable("Edna", 2000));
					localThread.start();
				}
			});
			add(localJButton3);
		}
	}

	class ButtonPanel$1 implements ActionListener {
		ButtonPanel$1(ButtonPanel paramButtonPanel) {
		}

		public void actionPerformed(ActionEvent paramActionEvent) {
			Thread localThread = new Thread(new WorkerRunnable("Tim", 5000));
			localThread.start();
		}
	}

	class ButtonPanel$2 implements ActionListener {
		ButtonPanel$2(ButtonPanel paramButtonPanel) {
		}

		public void actionPerformed(ActionEvent paramActionEvent) {
			Thread localThread = new Thread(new WorkerRunnable("Suzy", 3000));
			localThread.start();
		}
	}

	class ButtonPanel$3 implements ActionListener {
		ButtonPanel$3(ButtonPanel paramButtonPanel) {
		}

		public void actionPerformed(ActionEvent paramActionEvent) {
			Thread localThread = new Thread(new WorkerRunnable("Edna", 2000));
			localThread.start();
		}
	}

	class ThreadedWorkerFrame$ButtonPanel$1 implements ActionListener {
		ThreadedWorkerFrame$ButtonPanel$1(ThreadedWorkerFrame.ButtonPanel paramButtonPanel,
				ThreadedWorkerFrame paramThreadedWorkerFrame, JButton paramJButton) {
		}

		public void actionPerformed(ActionEvent paramActionEvent) {
			this.val$timButton.setEnabled(false);
			Thread localThread = new Thread(new ThreadedWorkerFrame.WorkerRunnable(this.this$1.this$0, "Tim", 5000));
			localThread.start();
		}
	}

	class ThreadedWorkerFrame$ButtonPanel$2 implements ActionListener {
		ThreadedWorkerFrame$ButtonPanel$2(ThreadedWorkerFrame.ButtonPanel paramButtonPanel,
				ThreadedWorkerFrame paramThreadedWorkerFrame, JButton paramJButton) {
		}

		public void actionPerformed(ActionEvent paramActionEvent) {
			this.val$suzyButton.setEnabled(false);
			Thread localThread = new Thread(new ThreadedWorkerFrame.WorkerRunnable(this.this$1.this$0, "Suzy", 3000));
			localThread.start();
		}
	}

	class ThreadedWorkerFrame$ButtonPanel$3 implements ActionListener {
		ThreadedWorkerFrame$ButtonPanel$3(ThreadedWorkerFrame.ButtonPanel paramButtonPanel,
				ThreadedWorkerFrame paramThreadedWorkerFrame, JButton paramJButton) {
		}

		public void actionPerformed(ActionEvent paramActionEvent) {
			this.val$ednaButton.setEnabled(false);
			Thread localThread = new Thread(new ThreadedWorkerFrame.WorkerRunnable(this.this$1.this$0, "Edna", 2000));
			localThread.start();
		}
	}

	class ThreadedWorkerFrame$ButtonPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ThreadedWorkerFrame$ButtonPanel(final ThreadedWorkerFrame paramThreadedWorkerFrame) {
			final JButton localJButton1 = new JButton("Tim (5 sec)");
			final JButton localJButton2 = new JButton("Suzy (3 sec)");
			final JButton localJButton3 = new JButton("Edna (2 sec)");

			localJButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					localJButton1.setEnabled(false);
					Thread localThread = new Thread(new ThreadedWorkerFrame.WorkerRunnable(
							ThreadedWorkerFrame.ButtonPanel.this.this$0, "Tim", 5000));
					localThread.start();
				}
			});
			add(localJButton1);
			localJButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					localJButton2.setEnabled(false);
					Thread localThread = new Thread(new ThreadedWorkerFrame.WorkerRunnable(
							ThreadedWorkerFrame.ButtonPanel.this.this$0, "Suzy", 3000));
					localThread.start();
				}
			});
			add(localJButton2);
			localJButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					localJButton3.setEnabled(false);
					Thread localThread = new Thread(new ThreadedWorkerFrame.WorkerRunnable(
							ThreadedWorkerFrame.ButtonPanel.this.this$0, "Edna", 2000));
					localThread.start();
				}
			});
			add(localJButton3);
		}
	}

	class ThreadedWorkerFrame$WorkerRunnable1 implements Runnable {
		private String name;
		private int delay;

		public ThreadedWorkerFrame$WorkerRunnable1(ThreadedWorkerFrame paramThreadedWorkerFrame, String paramString,
				int paramInt) {
			this.name = paramString;
			this.delay = paramInt;
		}

		public void run() {
			long l = 0L;
			for (;;) {
				synchronized (this.this$0) {
					ThreadedWorkerFrame.access$000(this.this$0)
							.append(this.name + " is working, count = " + l++ + "\n");
				}
				try {
					Thread.sleep(this.delay);
				} catch (InterruptedException localInterruptedException) {
				}
			}
		}
	}

class WorkerRunnable
implements Runnable
{
private String name;
private int delay;

public WorkerRunnable(String paramString, int paramInt)
{
  this.name = paramString;
  this.delay = paramInt;
}

public void run()
{
  long l = 0L;
  for (;;)
  {
    System.out.println(this.name + " is working, count = " + l++);
    try
    {
      Thread.sleep(this.delay);
    }
    catch (InterruptedException localInterruptedException) {}
  }
}
}

