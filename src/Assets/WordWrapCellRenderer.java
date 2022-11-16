package Assets;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class WordWrapCellRenderer extends JTextArea implements TableCellRenderer
{
    public WordWrapCellRenderer()
    {
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(new java.awt.Font("Segoe UI", 0, 18));
        setBorder(null);
        setBackground(new Color(255,255,255));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setText( (value == null) ? "" : value.toString() );
        setSize(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight(row));

        //  Recalculate the preferred height now that the text and renderer width have been set.

        int preferredHeight = getPreferredSize().height;

        if (table.getRowHeight(row) != preferredHeight)
        {
            table.setRowHeight(row, preferredHeight);
        }

        return this;
    }}
