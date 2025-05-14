import telebot
from telebot import types
from config import *

bot = telebot.TeleBot(BOT_TOKEN)   

bot.infinity_polling()