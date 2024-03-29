package net.minecraft.src;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JTextArea;
import net.minecraft.src.GuiLogFormatter;

public class GuiLogOutputHandler extends Handler {

   private int[] field_79023_b = new int[1024];
   private int field_79024_c = 0;
   Formatter field_79025_a = new GuiLogFormatter(this);
   private JTextArea field_79022_d;


   public GuiLogOutputHandler(JTextArea p_i4102_1_) {
      this.setFormatter(this.field_79025_a);
      this.field_79022_d = p_i4102_1_;
   }

   public void close() {}

   public void flush() {}

   public void publish(LogRecord p_publish_1_) {
      int var2 = this.field_79022_d.getDocument().getLength();
      this.field_79022_d.append(this.field_79025_a.format(p_publish_1_));
      this.field_79022_d.setCaretPosition(this.field_79022_d.getDocument().getLength());
      int var3 = this.field_79022_d.getDocument().getLength() - var2;
      if(this.field_79023_b[this.field_79024_c] != 0) {
         this.field_79022_d.replaceRange("", 0, this.field_79023_b[this.field_79024_c]);
      }

      this.field_79023_b[this.field_79024_c] = var3;
      this.field_79024_c = (this.field_79024_c + 1) % 1024;
   }
}
