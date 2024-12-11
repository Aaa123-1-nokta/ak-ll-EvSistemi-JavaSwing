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

/**
 *
 * @author zumre
 */
public class GuvenlikUI extends JFrame{
    public GuvenlikUI(){
        // Resim Label'ı
        JLabel label = new JLabel();
        label.setBounds(55, -50, 400, 400); // ana resmin konumu ve boyutu
        add(label); // JLabel'i panele ekle
        ImageIcon resim = resizeImage("src/akillievsistemi/guvelikresim/guvenlikana.png", 250, 200); // 300*300 boyutunda resmi ayarla
        label.setIcon(resim);
        
        // Ana frame ayarları
        setTitle("Guvenlik");
        setSize(370, 679);
        setLocationRelativeTo(null); // Pencereyi ortala
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        // Resim Label'ı
        JLabel label2 = new JLabel();
        label2.setBounds(0, -340, 390, 710); // saat konumu ve boyutu
        ImageIcon resim2 = resizeImage("src/akillievsistemi/aydinlatmaresimler/saat.png", 370, 36); // 200x200 boyutunda resmi ayarla
        label2.setIcon(resim2);
        add(label2); // JLabel'i panele ekle
        
        JLabel label3 = new JLabel();
        label3.setBounds(-5, 433, 390, 400); // saat konumu ve boyutu
        ImageIcon kı = resizeImage("src/akillievsistemi/aydinlatmaresimler/kısayol2.png", 380, 38); // 200x200 boyutunda resmi ayarla
        label3.setIcon(kı);
        add(label3); // JLabel'i panele ekle
        
        //yazı ekleme
        JLabel label1 = new JLabel("Lütfen oda seçiniz");
        label1.setBounds(75, 125, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 20); // Düz Courier New fontu

        label1.setFont(yazisekli);
        add(label1); // JLabel'i pencereye ekle
        
        
       //geri butonu için
        JButton geri=new JButton("");
        geri.setBounds(10, 70, 30, 30);
        geri.setBackground(new Color(255,255,255)); // Pastel kırmızı-pembe renk
        ImageIcon geriaydin = resizeImage("src/akillievsistemi/aydinlatmaresimler/gerii.png", 30,30); // Resmi 30x30 boyutlandır
        geri.setIcon(geriaydin);
        geri.setForeground(new Color(0,0,0,140));
        geri.setOpaque(false); // Butonun arka planını görünür kıl
        geri.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır.
        geri.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10000, 10000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(geri); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
        geri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Mevcut Aydınlatma sınıfına git
                new AkilliEvSistemi();
            }
        }); 
        
        //kapat butonu için
        JButton kapatay=new JButton("");
        kapatay.setBounds(315, 70, 30, 30);
        kapatay.setBackground(new Color(255,255,255)); // Pastel kırmızı-pembe renk
        ImageIcon kapataydin = resizeImage("src/akillievsistemi/aydinlatmaresimler/rty2.png", 30,30); // Resmi 30x30 boyutlandır
        kapatay.setIcon(kapataydin);
        kapatay.setForeground(new Color(0,0,0,140));
        kapatay.setOpaque(false); // Butonun arka planını görünür kıl
        kapatay.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır.
        kapatay.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10000, 10000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(kapatay); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
        kapatay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Mevcut Aydınlatma sınıfına git
                JOptionPane.showMessageDialog(null, "Tüm guvenlik sisteminden çıkış yapılıyor.");
            }
        }); 
    
    
        
        
       //mutfak aydınlatma
        JButton mutfak=new JButton("Mutfak");
        mutfak.setBounds(27, 305, 135, 135);
        mutfak.setBackground(new Color(189, 252, 201)); // Pastel kırmızı-pembe renk
        ImageIcon icon = resizeImage("src/akillievsistemi/aydinlatmaresimler/pp2.png", 95, 95); // Resmi 70x70 boyutlandır
        mutfak.setIcon(icon);
        mutfak.setForeground(new Color(0,0,0,140));
        mutfak.setOpaque(false); // Butonun arka planını görünür kıl
        mutfak.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonaydinlatma = new Font("ARIAL", Font.ITALIC, 22);
        mutfak.setFont(butonaydinlatma);
        mutfak.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        mutfak.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala

        mutfak.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        add(mutfak); // Aydınlatma butonunu panele ekle
         
        mutfak.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        GuvenlikAbstract mutfak=GuvenlikFabrikasi.guvenyap("mutfak");
    }
});
        
       
        
        //yatakodası aydınlatma
        JButton yatakbuton = new JButton("Yatak Odası");
        yatakbuton.setBounds(205,305, 135, 135);
        yatakbuton.setBackground(new Color(221, 160, 221)); // Pastel kırmızı-pembe renk
        ImageIcon yatakaydin = resizeImage("src/akillievsistemi/aydinlatmaresimler/sleep6.png", 85, 85); // Resmi 70x70 boyutlandır
        yatakbuton.setIcon(yatakaydin);
        yatakbuton.setForeground(new Color(0,0,0,140));
        yatakbuton.setOpaque(false); // Butonun arka planını görünür kıl
        yatakbuton.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font yatak = new Font("ARIAL", Font.ITALIC, 20);
        yatakbuton.setFont(yatak);
        yatakbuton.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        yatakbuton.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        yatakbuton.setUI(new BasicButtonUI() {
            
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        yatakbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YatakAydınlatma1 yatakAydınlatması = new YatakAydınlatma1.YatakAydınlatmaBuilder(20.0f,920)
                .setKapaliMİ(true)        
                .setGece(true)
                .setYatakEtki(true)
                 .build();  // Builder ile nesneyi oluşturuyoruz

        // Mutfak aydınlatma ekranını başlatıyoruz
        yatakAydınlatması.yatakuı();  //
            }
        });

       add(yatakbuton);
        
        
        //balkon aydınlatma
        JButton balkonbuton = new JButton("Balkon");
        balkonbuton.setBounds(205, 460, 135, 135);
        balkonbuton.setBackground(new Color(173, 216, 230)); // Pastel kırmızı-pembe renk
        ImageIcon balkonaydin = resizeImage("src/akillievsistemi/aydinlatmaresimler/balcony.png", 85, 85); // Resmi 70x70 boyutlandır
        balkonbuton.setIcon(balkonaydin);       
        balkonbuton.setForeground(new Color(0,0,0,140));
        balkonbuton.setOpaque(false); // Butonun arka planını görünür kıl
        balkonbuton.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font balkon = new Font("ARIAL", Font.ITALIC, 20);
        balkonbuton.setFont(balkon);
        balkonbuton.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        balkonbuton.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        balkonbuton.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        balkonbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BalkonAydınlatma1 balkonAydınlatması = new BalkonAydınlatma1.BalkonAydınlatmaBuilder(30.9f,120)
                .setacikhavaModuu(true)
                .setbalkonlamba(true)
                .build();
                balkonAydınlatması.balkonuı();  //


            }
        });
        add(balkonbuton);
        
        
        //salon aydınlatma
        JButton salonbuton = new JButton(" Salon ");
        salonbuton.setBounds(27, 460, 135, 135);
        salonbuton.setBackground(new Color(255, 255, 163)); // Pastel kırmızı-pembe renk
        ImageIcon salonaydin = resizeImage("src/akillievsistemi/aydinlatmaresimler/salon.png", 90, 90); // Resmi 70x70 boyutlandır
        salonbuton.setIcon(salonaydin);
        salonbuton.setForeground(new Color(0,0,0,140));
        salonbuton.setOpaque(false); // Butonun arka planını görünür kıl
        salonbuton.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font salon = new Font("ARIAL", Font.ITALIC, 20);
        salonbuton.setFont(salon);
        salonbuton.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        salonbuton.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        salonbuton.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        salonbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalonAydınlatma salonAydınlatması = new SalonAydınlatma.SalonAydınlatmaBuilder(60,220)
                .setEtkilesim(true)
                .setGece(true)
                        .setKapaliMİ(true)
                        .build();
                salonAydınlatması.salonuı();
                        

            }
        });

        add(salonbuton);

        setVisible(true);
    }
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }
   
    
}