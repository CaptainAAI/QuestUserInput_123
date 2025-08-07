package com.example.questuserinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HelloContent() {
    var prodiText by remember { mutableStateOf("") }
    var namaText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contoh TextField",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        // TextField tanpa label "Prodi"
        TextField(
            value = prodiText,
            onValueChange = { prodiText = it },
            label = { Text("Prodi") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // OutlinedTextField dengan label "Nama"
        OutlinedTextField(
            value = namaText,
            onValueChange = { namaText = it },
            label = { Text("Nama") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // TextField untuk password
        TextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }

}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: $count")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text(text = "Increment Counter")
        }
    }
}

@Composable
fun RememberSaveableExample() {
    var savedText by rememberSaveable { mutableStateOf("Teks Awal") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = savedText,
            onValueChange = { savedText = it },
            label = { Text("Ketik di sini") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Teks yang dimasukkan: $savedText")
    }
}

@Composable
fun ContohRadioButton() {
    val options = listOf("Laki-laki", "Perempuan", "Lainnya")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Pilih Jenis Kelamin:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        options.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (item == selectedOption),
                    onClick = { selectedOption = item }
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Terpilih: $selectedOption",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var namaText by remember { mutableStateOf("") }
    var alamatText by remember { mutableStateOf("") }
    var selectedJK by remember { mutableStateOf("") }

    var submittedNama by remember { mutableStateOf("") }
    var submittedAlamat by remember { mutableStateOf("") }
    var submittedJK by remember { mutableStateOf("") }

    val genderOptions = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = namaText,
            onValueChange = { namaText = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nama Lengkap") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Jenis Kelamin:")
            Spacer(modifier = Modifier.width(16.dp))
            genderOptions.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedJK == item,
                        onClick = { selectedJK = item }
                    )
                    Text(item)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = alamatText,
            onValueChange = { alamatText = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Alamat Lengkap") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = namaText.isNotEmpty() && alamatText.isNotEmpty() && selectedJK.isNotEmpty(),
            onClick = {
                submittedNama = namaText
                submittedJK = selectedJK
                submittedAlamat = alamatText
            }
        ) {
            Text(text = "Submit")
        }

        Spacer(modifier = Modifier.height(32.dp))
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onSurface
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Nama: $submittedNama", color = MaterialTheme.colorScheme.onPrimaryContainer)
                Text(text = "Gender: $submittedJK", color = MaterialTheme.colorScheme.onPrimaryContainer)
                Text(text = "Alamat: $submittedAlamat", color = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }
    }
}
