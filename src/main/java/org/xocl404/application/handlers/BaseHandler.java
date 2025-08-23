package org.xocl404.application.handlers;

import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.models.BaseDto;

/**
 * Базовый абстрактный класс для цепочки обязанностей
 */
public abstract class BaseHandler implements IHandler {

    protected IHandler next = null;

    /**
     * Метод, который добавляет следующего обработчика в цепочку
     *
     * @param handler - обработчик, которого нужно добавить
     *
     * @return IHandler - возвращает себя после добавления нового обработчика
     */
    public IHandler addNext(IHandler handler)
    {
        if (next == null)
        {
            next = handler;
        }
        else
        {
            next.addNext(handler);
        }

        return this;
    }

    /**
     * Абстрактный метод, который обрабатывает команду
     *
     * @param command - команда, поданная для обработки
     *
     * @return BaseDto - возвращает объект базового класса для передачи данных
     */
    public abstract BaseDto handle(BaseCommand command) throws Exception;
}
