package stage;

//import lab2bai1.FrameQLSV;

import layout.QLSVJFrame;

//import lab2bai2.CasioFrame;
//import lab2bai3.;
//import lab2bai3.RadioButton;

/**
 *
 * @author TinDev
 */
public class stage {
    
    public static void main(String[] args) {
//        FrameQLSV qlsv = new FrameQLSV();
//        CasioFrame casio = new CasioFrame();
        QLSVJFrame qlsv = new QLSVJFrame("test");
        //RadioButton radio = new RadioButton();
        qlsv.setVisible(true);
        qlsv.setSize(650, 500);
        qlsv.setLocationRelativeTo(null);
    }
}
