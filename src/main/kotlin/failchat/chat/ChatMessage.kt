package failchat.chat

import failchat.Origin
import java.time.Instant

/**
 * Сообщение из чата какого-либо первоисточника.
 * */
open class ChatMessage(
        /**
         * Внутренний id, генерируемый приложением.
         * */
        val id: Long,

        /**
         * Первоисточник сообщения.
         * */
        val origin: Origin,

        /**
         * Автор сообщения.
         * */
        val author: Author,

        /**
         * Текст сообщения.
         * */
        var text: String,

        /**
         * Время получения сообщения.
         * */
        val timestamp: Instant = Instant.now()
) {

    /**
     * Could contains next elements:
     * - [Emoticon]
     * - [Link]
     * - [Image]
     * */
    val elements: List<Any> get() = mutableElements

    var highlighted = false

    private val mutableElements: MutableList<Any> = ArrayList()

    /**
     * @return formatted string for added element.
     * */
    fun addElement(element: Any): String {
        mutableElements.add(element)
        return "{!${mutableElements.size - 1}}"
    }

    fun replaceElement(index: Int, replacement: Any): Any? {
        return mutableElements.set(index, replacement)
    }

    override fun toString(): String {
        return "ChatMessage(id=$id, origin=$origin, author=$author, text='$text', timestamp=$timestamp, " +
                "highlighted=$highlighted, mutableElements=$mutableElements)"
    }

}
