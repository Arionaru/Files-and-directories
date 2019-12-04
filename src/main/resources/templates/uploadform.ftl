<#import "common.ftl" as c>
<@c.page>


    <h3>${message?if_exists}</h3>

    <div>
        <form method="POST" action="/">
            <div class="input-group mb-3">
                <label>Новая директория: </label><input type="text" class="form-control" name="dir" />
                <button class="btn btn-primary" type="submit">Добавить в список</button>
            </div>
        </form>
    </div>

    <table class="table table-hover">
        <tr>
            <th>Дата</th>
            <th>Базовая директория</th>
            <th>Директорий</th>
            <th>Файлов</th>
            <th>Суммарный размер файлов</th>
            <th> </th>
        </tr>
        <#list dirs as dir>
        <tr>
            <td>${dir.date?if_exists}</td>
            <td>${dir.link?if_exists}</td>
            <td>${dir.countDirs}</td>
            <td>${dir.countFiles}</td>
            <td>${dir.filesSize}</td>
            <td><button class="btn btn-secondary" type="button" onclick="window.open('/${dir.id}')">Файлы</button></td>
        </tr>
        </#list>
    </table>

</@c.page>

