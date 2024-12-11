package akillievsistemi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;

public class AkilliEvSistemi extends JFrame {
    private Aydinlatma1 aydinlatma; // Akıllı ev sistemi bir aydınlatmaya sahiptir (association)

    public AkilliEvSistemi() {
        // Ana frame ayarları
            setTitle("TETRA HOME");
        setSize(370, 679); //ana frame büyüklüğü
        setLocationRelativeTo(null); // Pencereyi ortala
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
// Resim Label'ı
        JLabel label2 = new JLabel();
        label2.setBounds(0, -340, 390, 710); // Yazının konumu ve boyutu
        ImageIcon resim2 = resizeImage("src/akillievsistemi/aydinlatmaresimler/saat.png", 370, 36); // 370*36 unda resmi ayarla
        label2.setIcon(resim2);
        add(label2); // JLabel'i panele ekle
        
        // Resim Label'ı
        JLabel label = new JLabel();
        label.setBounds(35, 30, 300, 300); 
        ImageIcon resim = resizeImage("src/akillievsistemi/aydinlatmaresimler/anaresim.png", 300, 300); // 300*300 boyutunda resmi ayarla
        label.setIcon(resim);
        add(label); // JLabel'i panele ekle
        
        
        //yazı ekleme
        JLabel label1 = new JLabel("TETRA HOME");
        label1.setBounds(95, 125, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 30); // Düz Courier New fontu

        label1.setFont(yazisekli);
        add(label1); // JLabel'i pencereye ekle
        
        JLabel label3 = new JLabel();
        label3.setBounds(-5, 433, 390, 400); // saat konumu ve boyutu
        ImageIcon tuslar = resizeImage("src/akillievsistemi/aydinlatmaresimler/kısayol2.png", 380, 38); // 38x380 boyutunda resmi ayarla
        label3.setIcon(tuslar);
        add(label3); // JLabel'i panele ekle
        
        //aydınlatma butonu için
        JButton aydinlatma=new JButton("Aydınlatma");
        aydinlatma.setBounds(27, 305, 135, 135);
        aydinlatma.setBackground(new Color(243, 197, 195)); // Pastel kırmızı-pembe renk
        ImageIcon icon = resizeImage("src/akillievsistemi/aydinlatmaresimler/LAMBA6.png", 70, 75); // Resmi 70x75 boyutlandır
        aydinlatma.setIcon(icon);
        aydinlatma.setForeground(new Color(0,0,0,140));
        aydinlatma.setOpaque(false); // Butonun arka planını görünür kıl
        aydinlatma.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonaydinlatma = new Font("ARIAL", Font.ITALIC, 20);
        aydinlatma.setFont(butonaydinlatma);
        aydinlatma.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        aydinlatma.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala

        aydinlatma.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(aydinlatma); // Aydınlatma butonunu panele ekle
         
        aydinlatma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mevcut Aydınlatma sınıfına git
                new Aydinlatma1(); // Aydınlatma sınıfını burada çağırıyoruz
            }
        }); 
          
          
         //guvenlik butonu için
        JButton guven=new JButton("Güvenlik");
        guven.setBounds(205, 305, 135, 135);
        guven.setBackground(new Color(255, 179, 217)); // Pastel kırmızı-pembe renk
        ImageIcon guven1 = resizeImage("src/akillievsistemi/aydinlatmaresimler/guven6.png", 130, 75); // Resmi 130x75 boyutlandır
        guven.setIcon(guven1);
        guven.setForeground(new Color(0,0,0,140));
        guven.setOpaque(false); // Butonun arka planını görünür kıl
        guven.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butongu = new Font("ARIAL", Font.ITALIC, 20);
        guven.setFont(butongu);
        guven.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        guven.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        //guvenlik butonuna ovallik verince
        guven.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(guven); // Aydınlatma butonunu panele ekle
        //guvenlik butonuna basınca
        guven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mevcut güvenlik sınıfına git
                new GuvenlikUI(); // Aydınlatma sınıfını burada çağırıyoruz
            }
        }); 
        
         
        //priz butonu için
        JButton priz=new JButton("Akıllı Priz");
        priz.setBounds(27, 460, 135, 135);
        priz.setBackground(new Color(192, 192, 192)); // Pastel kırmızı-pembe renk
        ImageIcon prizfoto = resizeImage("src/akillievsistemi/aydinlatmaresimler/ppson.png", 70, 70); // Resmi 70x70 boyutlandır
        priz.setIcon(prizfoto);
        priz.setForeground(new Color(0,0,0,140));
        priz.setOpaque(false); // Butonun arka planını görünür kıl
        priz.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonpri = new Font("ARIAL", Font.ITALIC, 20);
        priz.setFont(butonpri);
        priz.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        priz.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        priz.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });

        add(priz); // Aydınlatma butonunu panele ekle
        //akıllıpriz butonuna basıldığında
        /*priz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mevcut Aydınlatma sınıfına git
                new Aydinlatma1(); // Aydınlatma sınıfını burada çağırıyoruz
    }
}); */
          
        //nemm ve su
        JButton nem=new JButton("Su ve nem");
        nem.setBounds(205, 460, 135, 135);
        nem.setBackground(new Color(174, 198, 228)); // Pastel kırmızı-pembe renk
        ImageIcon nemfoto = resizeImage("src/akillievsistemi/aydinlatmaresimler/zne.png", 70, 70); // Resmi 70x70 boyutlandır
        nem.setIcon(nemfoto);
        nem.setForeground(new Color(0,0,0,140));
        nem.setOpaque(false); // Butonun arka planını görünür kıl
        nem.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonem = new Font("ARIAL", Font.ITALIC, 20);
        nem.setFont(butonem);
        nem.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        nem.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        nem.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(nem); // nemve su butonunu panele ekle
        //nem ve su butonuna basıldığında
        nem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Mevcut Aydınlatma sınıfına git
            new Aydinlatma1(); // Aydınlatma sınıfını burada çağırıyoruz
            }
        }); 
        setVisible(true); // Frame'yi görünür yap.
    
    
       //kapat butonu için
        JButton kapat=new JButton("");
        kapat.setBounds(315, 70, 30, 30);
        kapat.setBackground(new Color(255,255,255)); // Pastel kırmızı-pembe renk
        ImageIcon gerifoto = resizeImage("src/akillievsistemi/aydinlatmaresimler/akilliEv/rty2.png", 30,30); // Resmi 30x30 boyutlandır
        kapat.setIcon(gerifoto);
        kapat.setForeground(new Color(0,0,0,140));
        kapat.setOpaque(false); // Butonun arka planını görünür kıl
        kapat.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır.
        kapat.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10000, 10000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(kapat); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
        kapat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mevcut Aydınlatma sınıfına git
                JOptionPane.showMessageDialog(null, "Akıllı ev sisteminden çıkış yapılıyor.");
                setVisible(false);
            }
        }); 
    }
          

    public static void main(String[] args) {
        new AkilliEvSistemi(); // Ana frameyi oluştur
    }
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }
}
