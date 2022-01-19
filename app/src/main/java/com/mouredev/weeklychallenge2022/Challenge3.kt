package com.mouredev.weeklychallenge2022

/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val range = (1..100)

    getPrimes(range).also {
        println("List of prime numbers: $it")
    }
}

// Used:  The sieve of Eratosthenes for finding all prime numbers up to any given limit
private fun getPrimes(range: IntRange): List<Int> {
    var list = range.toMutableList().also { println("List of input number: $it") }
    var pointer = list.indices.first

    while (list[pointer] * list[pointer] < list.last()) {
        if (list[pointer] != 1) {
            val subList = list.subList(pointer, list.lastIndex)
            val noPrimesValuesList = subList
                .filter { it != list[pointer] }
                .filter { it % list[pointer] == 0 }
                .map { it }
                .toList()
            list.removeAll(noPrimesValuesList)
        }
        pointer++
    }

    return list
}
