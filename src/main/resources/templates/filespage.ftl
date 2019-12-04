<#import "common.ftl" as c>
<@c.page>

    <h3>${path}</h3>
    </br>
    <table class="table table-hover">
    <tr>
        <th>Файл</th>
        <th>Размер</th>
    </tr>
    <#list dirs as dir>
        <tr>
        <td>${dir.fileName}</td>
        <td>${dir.size}</td>
        </tr>
    </#list>
    <#--<#list files as file>
        <tr>
        <td>${file.fileName}</td>
        <td>${file.size}</td>
        </tr>
    </#list>-->
    </table>
</@c.page>