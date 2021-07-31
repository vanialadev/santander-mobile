package com.example.listadecontatos.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO


class HelperDB(
    context: Context?
) : SQLiteOpenHelper(context, NOME_BRANCO, null, VERSAO_ATUAL) {

    companion object {
        private val NOME_BRANCO = "contato.db"
        private val VERSAO_ATUAL = 1
    }

    val TABLE_NAME = "contato"
    val COLUMNS_ID = "id"
    val COLUMNS_NOME = "nome"
    val COLUMNS_TELEFONE = "telefone"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "$COLUMNS_ID INTEGER NOT NULL," +
            "$COLUMNS_NOME TEXT NOT NULL,"  +
            "$COLUMNS_TELEFONE TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(oldVersion != newVersion){
            db?.execSQL(DROP_TABLE)
        }
        onCreate(db)
    }

    fun buscarContatos(busca: String, isBuscarPorID: Boolean = false) : List<ContatosVO>{
        val db = readableDatabase ?: return mutableListOf()
        var lista = mutableListOf<ContatosVO>()
        var where: String? = null
        var args: Array<String> = arrayOf()
        if(isBuscarPorID){
        //SEGUNDA OPÇÃO PARA FAZER O SELECT
            where = "$COLUMNS_ID = ?"
            args = arrayOf("$busca")
        }else{
            where = "$COLUMNS_NOME LIKE ?"
            args = arrayOf("%$busca%")
        }

        //PRIMEIRA OPÇÃO PARA FAZER O SELECT
        //val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMNS_NOME LIKE ?"

        var cursor = db.query(TABLE_NAME, null, where, args, null, null, null)

        if(cursor == null){
            db.close()
            return mutableListOf()
        }
        while (cursor.moveToNext()){
            var contato = ContatosVO(
                cursor.getInt(cursor.getColumnIndex(COLUMNS_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_NOME)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_TELEFONE))
            )
            lista.add(contato)
        }
        db.close()
        return lista
    }

    fun salvarContato(contato: ContatosVO){
        val db = writableDatabase ?: return

        //PRIMEIRA MANEIRA DE INSERIR DADOS NA TABELA
        //val sql = "INSERT INTO $TABLE_NAME ($COLUMNS_NOME, $COLUMNS_TELEFONE) VALUES (?,?)"
        //var array = arrayOf<String>(contato.nome, contato.telefone)
        //db.execSQL(sql, array)

        //SEGUNDA MANEIRA DE INSERIR DADOS NA TABELA
        var content = ContentValues()
        content.put(COLUMNS_NOME, contato.nome)
        content.put(COLUMNS_TELEFONE, contato.telefone)
        db.insert(TABLE_NAME, null, content)
        db.close()
    }

    fun deletarContato(id: Int){
        val db = writableDatabase ?: return
        //PRIMEIRA MANEIRA DE FAZER UM DELETE
        //val where = "id = ?"
        //val arg : Array<String> = arrayOf("$id")
        //db.delete(TABLE_NAME, where, arg)

        //SEGUNDA MANEIRA DE FAZER UM DELETE
        val sql = "DELETE FROM $TABLE_NAME WHERE $COLUMNS_ID = ?"
        val args = arrayOf("$id")
        db.execSQL(sql, args)
        db.close()
    }

    fun updateContato(contato: ContatosVO){
        val db = writableDatabase ?: return
        //PRIMEIRA OPÇÃO PARA FAZER UPDATE
        //val content = ContentValues()
        //content.put(COLUMNS_NOME, contato.nome)
        //content.put(COLUMNS_TELEFONE, contato.telefone)
        //val where = "id = ?"
        //var arg: Array<String> = arrayOf("${contato.id}")
        //db.update(TABLE_NAME, content, where, arg)

        //SEGUNDA OPÇÃO PARA FAZER UPDATE
        val sql = "UPDATE $TABLE_NAME SET $COLUMNS_NOME = ?, $COLUMNS_TELEFONE = ? WHERE $COLUMNS_ID = ?"
        val arg :Array<Any> = arrayOf(contato.nome, contato.telefone, contato.id)
        db.execSQL(sql, arg  )
        db.close()
    }
}