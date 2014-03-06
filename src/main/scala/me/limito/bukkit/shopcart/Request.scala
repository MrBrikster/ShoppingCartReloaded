package me.limito.bukkit.shopcart

import org.bukkit.command.CommandSender

abstract class Request(val requestManager: RequestManager, val commandSender: CommandSender) {
  /** Игрок не может одновременно запускать несколько вопросов с mustLock=true */
  val mustLock = false

  /** Здесь идет первичная обработка запроса (в игровом потоке) **/
  def handle()

  def completed() {
    requestManager.onCompleted(this)
  }
}