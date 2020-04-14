package com.example.applesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;
///14/04/2020  Для мальчика
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //календарь
        TextView dateDefault = (TextView)findViewById(R.id.dateDefault);
        TextView timeDefault = (TextView)findViewById(R.id.timeDefault);
        //установит значения по умолчанию для этих элементов: dateDefault и timeDefault
        //Элемент DatePicker позволяет пользователю выбрать дату (число, месяц, год).
        // Данный виджет используют как правило на отдельном экране. Т
        DatePicker dp = (DatePicker)this.findViewById(R.id.datePicker);
        // Месяц начиная с нуля. Для отображения добавляем 1.
        dateDefault.setText("Дата по умолчанию " + dp.getDayOfMonth() + "/" +
                (dp.getMonth() + 1) + "/" + dp.getYear());

        dp.init(2020, 04, 14, null); //устанавливаем дату по умолчанию
        //Компонент TimePicker позволяет пользователю выбрать время (часы, минуты).
        TimePicker tp = (TimePicker)this.findViewById(R.id.timePicker);
        //Класс java.util.Formatter обеспечивает поддержку выравнивания и выравнивания макета,
        // общие форматы для числовых, строковых данных и данных даты / времени
        java.util.Formatter timeF = new java.util.Formatter();
        timeF.format("Время по умолчанию %d:%02d", tp.getCurrentHour(),
                tp.getCurrentMinute());
        timeDefault.setText(timeF.toString());
        tp.setIs24HourView(true); // формат часов 24 часа
        tp.setCurrentHour(new Integer(10)); // сами задаем часы
        tp.setCurrentMinute(new Integer(24)); // сами задаем минуты
        //календарь
    }
    public void onToggleClicked(View view) {

        // включена ли кнопка
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // действия если включена
            Toast.makeText(this, "Свет включен", Toast.LENGTH_LONG).show();
        } else {
            // действия, если выключена
            Toast.makeText(this, "Свет выключен!", Toast.LENGTH_LONG).show();
        }
    }
    public void onCheckboxClicked(View view) {
        // Получаем флажки
        CheckBox java = (CheckBox) findViewById(R.id.java);
        CheckBox javascript = (CheckBox) findViewById(R.id.javascript);
        String  selectedItems = ""; //Выбранный элемент
        if(java.isChecked()) //если выбрана java
            selectedItems +=java.getText() + ", ";
        if(javascript.isChecked()) //если выбран javaSctript
            selectedItems +=javascript.getText();


        TextView selection = (TextView) findViewById(R.id.selection);
        selection.setText(selectedItems);
    }
}
