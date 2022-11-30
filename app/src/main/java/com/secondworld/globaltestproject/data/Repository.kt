package com.secondworld.globaltestproject.data

import com.secondworld.globaltestproject.ui.PersonItem
import javax.inject.Inject

class Repository @Inject constructor(){

    fun getPersons() : List<PersonItem> {

        val list = mutableListOf<PersonItem>()

        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST ), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.COURIER ), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.LAWYER ), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.IT), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.DOCTOR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.DRIVER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.HR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.COURIER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.LAWYER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.IT), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.HR, Profession.DOCTOR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.DOCTOR, Profession.HR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.COURIER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.IT, Profession.HR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.IT, Profession.COURIER, Profession.HR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.LAWYER, Profession.HR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.DRIVER, Profession.DOCTOR, Profession.COURIER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.DRIVER, Profession.HR, Profession.COURIER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.LAWYER, Profession.LAWYER, Profession.IT), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.DOCTOR, Profession.HR, Profession.IT), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.HR, Profession.LAWYER, Profession.DOCTOR), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.HR, Profession.COURIER), getRandomDescription()))
        list.add(PersonItem(getRandomId(), getRandomName(), getRandomAge(), listOf(Profession.ARTIST, Profession.COURIER, Profession.LAWYER), getRandomDescription()))

        return list
    }



    private fun getRandomAge() = (15..65).random()

    private fun getRandomDescription() = listOf(
        "Попали на необитаемый остров американец, немец и русский. Однажды прибило к острову бутылку, открыли они ее, а оттуда - джинн: - Вы меня освободили, я исполню по два ваших желания! - Мешок денег и домой! - сказал американец и исчез. - Кружку пива и домой! - сказал немец и был таков. - Хорошая была компания, ящик водки и всех обратно! - сказал русский. <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "Винни Пух поспорил с Пятачком, что выпьет море. Три дня пил он море, да все и выпил. Через час несётся в ужасе Пятачок по лесу и орёт во все горло: - Звери караул, спасайтесь, кто может, Пух писать хочет! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "Чебурашка нашёл копейку и спрашивает у Гены: - Гена, а копейка это мало или много? - Да ты теперь миллионер! - шутит крокодил. Чебурашка заходит в магазин, набирает много дорогих игрушек, подаёт копейку удивлённому продавцу и говорит: - Ну чего смотришь, давай сдачу! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "- Вовочка, ты чего такой расстроенный? - Садись, Рома, расскажу. - Ну, рассказывай! - Представляешь, по ходу, скамейка то покрашена. <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "- Сегодня мы нашли группу русских туристов пропавших в джунглях Таити, все живы и здоровы! - Как вам это удалось, ведь их искали больше года? - Мы нашли их по матерящимся попугаям! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "Воспитательница в детском садике спрашивает: - Коля, ты умеешь считать? - Один, два, три, четыре, пять... - Машенька, продолжай! - Шесть, семь, восемь, девять... - Вовочка, считай дальше! - Десятка, валет, дама, король и туз! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "- Бабушка, а ты пришла сама? - Сама внученька, сама! - А папа сказал, что тебя черти принесли! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "Гена и Чебурашка поднимают холодильник на восьмой этаж. Чебурашка запыхавшись, говорит: - Гена, у меня есть хорошая новость и плохая. С какой начать? - Начни с хорошей! - Мы уже на седьмом этаже! - А плохая? - Мы подъезд перепутали! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
        "- Как сказать по татарски вперед? - спрашивает русский у татарина. - Алга! - говорит татарин. - А как сказать назад? - У татар нет назад, они разворачиваются и алга! <a href=\"https://anekdotbar.ru/top-100.html\">anekdotbar.ru</a>",
    ).random()

    private fun getRandomId() = (1..9999999).random()

    private fun getRandomName() = listOf<String>(
            "Max",
            "Ann",
            "Sara",
            "Tony",
            "Mike",
            "John",
            "Jerry",
            "Tomas",
            "Luise",
        ).random()


}