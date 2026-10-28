// U1 S3 Taller 3: Calculadora: sumar dos números (Android Nativo)
// Paralelo: 6SB
// Grupo: 6
// Integrantes:
//    1. Luna Peñafiel Romina
//    2. Pérez Abad Evelyn
//    3. Saa Chichande Solange
//    4. Sanaguaray Gusqui Jorge
//    5. Solís Calderón Dayanna

package ec.edu.agraria.sumadorauae; // Paquete de la aplicación SumadoraUAE.

import android.app.Activity; // Clase que representa una pantalla Android.
import android.os.Bundle; // Contenedor del estado inicial de la actividad.
import android.util.Log; // Herramienta para enviar mensajes a Logcat.
import android.view.View; // Clase utilizada para escuchar pulsaciones.
import android.widget.Button; // Vista que ejecutará la operación de suma.
import android.widget.EditText; // Vista para introducir cada número.
import android.widget.TextView; // Vista donde se visualizará el resultado.
import android.widget.Toast; // Mensaje breve de confirmación al usuario.

public class MainActivity extends Activity { // Clase principal que controla la pantalla.

    private static final String TAG = "APP"; // Etiqueta de los mensajes Log.d en Logcat.
    private EditText editTextNumero1; // Primer campo numérico declarado como atributo private.
    private EditText editTextNumero2; // Segundo campo numérico declarado como atributo private.
    private Button buttonSumar; // Botón Sumar declarado como atributo private.
    private TextView textViewResultado; // Resultado declarado como atributo private.

    @Override // Indica que se reemplaza el método del ciclo de vida de Activity.
    protected void onCreate(Bundle savedInstanceState) { // Se ejecuta al iniciar la pantalla.
        super.onCreate(savedInstanceState); // Conserva la inicialización de la clase padre.
        setContentView(R.layout.activity_main); // Muestra el diseño activity_main.xml.
        Log.d(TAG, "onCreate: pantalla cargada"); // Confirma en Logcat que se inició la pantalla.

        editTextNumero1 = findViewById(R.id.editTextNumero1); // Conecta XML con el primer EditText.
        editTextNumero2 = findViewById(R.id.editTextNumero2); // Conecta XML con el segundo EditText.
        buttonSumar = findViewById(R.id.buttonSumar); // Conecta XML con el botón Sumar.
        textViewResultado = findViewById(R.id.textViewResultado); // Conecta XML con el TextView del resultado.
        Log.d(TAG, "onCreate: componentes vinculados"); // Registra que findViewById terminó.

        buttonSumar.setOnClickListener(new View.OnClickListener() { // Escucha cuando el usuario pulsa Sumar.
            @Override // Indica que se implementa el evento onClick.
            public void onClick(View view) { // Método llamado al pulsar el botón.
                Log.d(TAG, "Botón Sumar pulsado"); // Registra el clic en Logcat.
                sumar(); // Ejecuta el método que valida, convierte y suma.
            } // Final del método onClick.
        }); // Final del registro del listener de pulsación.
    } // Final de onCreate.

    private void sumar() { // Método privado que realiza la suma de los campos.
        Log.d(TAG, "sumar() inicio"); // Marca el inicio de la operación en Logcat.
        String texto1 = editTextNumero1.getText().toString().trim(); // Obtiene el primer texto sin espacios extra.
        String texto2 = editTextNumero2.getText().toString().trim(); // Obtiene el segundo texto sin espacios extra.
        textViewResultado.setText(R.string.resultado_inicial); // Evita mostrar una suma anterior si hay un error.
        Log.d(TAG, "Textos capturados y preparados"); // Indica que ambos campos ya se leyeron.

        if (texto1.isEmpty()) { // Comprueba si el primer campo está vacío.
            editTextNumero1.setError(getString(R.string.error_campo_vacio)); // Indica el error en el primer campo.
            editTextNumero1.requestFocus(); // Sitúa el cursor donde debe escribir el usuario.
            Log.d(TAG, "Validación: primer campo vacío"); // Explica en Logcat por qué se canceló la suma.
            return; // Detiene la ejecución mientras falte el primer número.
        } // Final de la validación del primer campo.

        if (texto2.isEmpty()) { // Comprueba si el segundo campo está vacío.
            editTextNumero2.setError(getString(R.string.error_campo_vacio)); // Indica el error en el segundo campo.
            editTextNumero2.requestFocus(); // Sitúa el cursor en el segundo campo.
            Log.d(TAG, "Validación: segundo campo vacío"); // Explica en Logcat por qué se canceló la suma.
            return; // Detiene la ejecución mientras falte el segundo número.
        } // Final de la validación del segundo campo.

        try { // Captura números que no puedan convertirse a enteros.
            int n1 = Integer.parseInt(texto1); // Convierte de texto a entero el primer número.
            int n2 = Integer.parseInt(texto2); // Convierte de texto a entero el segundo número.
            Log.d(TAG, "n1 = " + n1); // Muestra en Logcat el primer número convertido.
            Log.d(TAG, "n2 = " + n2); // Muestra en Logcat el segundo número convertido.
            int suma = n1 + n2; // Suma los enteros; el máximo de 9 dígitos por campo evita desbordamiento.
            Log.d(TAG, "resultado = " + suma); // Muestra en Logcat el resultado de la suma.
            textViewResultado.setText(getString(R.string.resultado_formato, suma)); // Muestra Resultado: 12 si n1=7 y n2=5.
            Log.d(TAG, "Resultado mostrado en pantalla"); // Confirma en Logcat que se actualizó el TextView.
            Toast.makeText(this, R.string.toast_operacion_exitosa, Toast.LENGTH_SHORT).show(); // Confirma la operación con un Toast.
            Log.d(TAG, "Toast de confirmación mostrado"); // Registra la confirmación del usuario.
        } catch (NumberFormatException e) { // Evita un cierre si algún texto no es un entero válido.
            Log.d(TAG, "Error al convertir los números: " + e.getMessage()); // Registra la causa del fallo.
            editTextNumero1.setError(getString(R.string.error_numero_invalido)); // Señala una entrada potencialmente incorrecta.
            editTextNumero2.setError(getString(R.string.error_numero_invalido)); // Señala la otra entrada para su revisión.
            Toast.makeText(this, R.string.toast_numero_invalido, Toast.LENGTH_SHORT).show(); // Muestra un aviso sin cerrar la app.
        } // Final del manejo seguro de números inválidos.
    } // Final del método sumar.
} // Final de MainActivity.
